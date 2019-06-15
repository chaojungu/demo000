package cn.t09.auth.sys.controller;

import cn.demo.domain.TreeNode;
import cn.t09.auth.sys.entity.Menu;
import cn.t09.auth.sys.entity.RoleMenu;
import cn.t09.auth.sys.service.IMenuService;
import cn.t09.auth.sys.service.IRoleMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.t09.demo.common.controller.BaseController;
import com.t09.demo.common.domain.AjaxResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author t09
 * @since 2019-06-12
 */

@Controller
@RequestMapping("/sys/menus")

public class MenuController extends BaseController {

    @Resource
    private IMenuService menuService;
    @Resource
    private IRoleMenuService roleMenuService;

    @GetMapping("{menuId}")
    @ResponseBody
    public AjaxResult getById(@PathVariable Long menuId) {
        Menu menu = menuService.getById(menuId);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, menu);
    }

    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestBody Menu menu) throws Exception {
        menuService.save(menu);
        return AjaxResult.ok();
    }

    @PutMapping
    @ResponseBody
    public AjaxResult update(@RequestBody Menu menu) throws Exception {
        menuService.updateById(menu);
        return AjaxResult.ok();
    }

    @DeleteMapping
    @ResponseBody
    public AjaxResult delete(@RequestBody List<Long> menuIds) throws Exception {

        menuService.removeByIds(menuIds);
        return AjaxResult.ok();
    }

    @GetMapping
    @ResponseBody
    public AjaxResult list(@RequestParam(value = "page", defaultValue = "1") Long pageIndex,
        @RequestParam(value = "rows", defaultValue = "5") Long pageSize,
        Menu menu) {
        IPage<Menu> page = new Page<>(pageIndex, pageSize);
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>(menu);
        menuService.page(page, queryWrapper);
        return AjaxResult.ok().put("data", page);
    }

    @GetMapping("/tree")
    @ResponseBody
    public Object listTree() {
        // 先查询所有权限菜单
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("type", 0, 1);
        List<Menu> menuList = menuService.list(queryWrapper);

        // 把所有权限菜单转换为treeNode
        List<TreeNode> treeNodeList = convertToTreeNodeList(menuList);

        return convertNodeListToTree(0L, treeNodeList);
    }
    @GetMapping("/tree/{roleId}")
    @ResponseBody
    public Object listTreeBy(@PathVariable  Long roleId) {
        // 先查询所有权限菜单树
        List<TreeNode> treeNodeList =getMenusByParentId(0L);
        markCheckedWithRoleId(roleId,treeNodeList);
        return treeNodeList;
    }

    private  List<TreeNode> getMenusByParentId(Long parentId) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_Id",parentId);
        List<Menu> menuList = menuService.list(queryWrapper);
        // 把所有权限菜单转换为treeNode
        List<TreeNode> treeNodeList = convertToTreeNodeList(menuList);
        // 查询子菜单
        for (TreeNode treeNode : treeNodeList) {
            List<TreeNode> subMenuList = getMenusByParentId(treeNode.getId());
            if (menuList.size()>0){
                treeNode.setChildren(subMenuList);
            }
        }

        return treeNodeList;
    }

    private void markCheckedWithRoleId(Long roleId, List<TreeNode> treeNodeList) {
        // 如果是超级管理员角色,所有权限设置为checked
        if (roleId.equals(1L)) {
            for (TreeNode treeNode : treeNodeList) {
                treeNode.setChecked(true);
            }
            return;
        }
        // 其他角色
        // 查询角色拥有的菜单id
        QueryWrapper<RoleMenu> roleMenuQueryWraper = new QueryWrapper<RoleMenu>()
            .eq("role_id", roleId);
        List<RoleMenu> roleMenuList = roleMenuService.list(roleMenuQueryWraper);

        // 根据角色拥有权限标记对应的treeNode为checked
        markCheckedTreeNode(roleMenuList, treeNodeList);
    }

    private List<TreeNode> convertNodeListToTree(Long parentId,  List<TreeNode> treeNodeList) {
        List<TreeNode> treeNodes = new ArrayList<>();

        Iterator<TreeNode> treeNodeIterator = treeNodeList.iterator();
        TreeNode treeNode = null;
        while (treeNodeIterator.hasNext()) {
            treeNode = treeNodeIterator.next();
            if (treeNode.getAttributes().get("_parentId").equals(parentId)) {
                treeNodes.add(treeNode);
                if (treeNode.getAttributes().get("type").equals(0)) {
                    treeNode.setChildren(convertNodeListToTree(treeNode.getId(), treeNodeList));
                }
            }
        }
        return treeNodes;
    }

    private void markCheckedTreeNode(List<RoleMenu> roleMenuList, List<TreeNode> treeNodeList) {
        for (TreeNode treeNode : treeNodeList) {
            treeNode.setChecked( containsInList( treeNode.getId(),roleMenuList) );
            if (null != treeNode.getChildren()) {
                markCheckedTreeNode(roleMenuList,treeNode.getChildren());
            }
        }
    }

    private Boolean containsInList(Long menuId,List<RoleMenu> roleMenuList) {
        for (RoleMenu roleMenu : roleMenuList) {
            if (roleMenu.getMenuId().equals(menuId)) {
                return true;
            }
        }
        return false;
    }

    private List<TreeNode> convertToTreeNodeList(List<Menu> menuList) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (Menu menu : menuList) {
            treeNodeList.add(convertToTreeNode(menu));
        }
        return treeNodeList;
    }

    private TreeNode convertToTreeNode(Menu menu) {
        TreeNode treeNode = new TreeNode();
        treeNode.setId(menu.getMenuId());
        treeNode.setText(menu.getName());
        treeNode.setIconCls(menu.getIcon());
        Map<String, Object> map = new HashMap<>();
        map.put("url", menu.getUrl());
        map.put("type", menu.getType());
        map.put("_parentId",menu.getParentId());
        treeNode.setAttributes(map);
        return treeNode;
    }

}
