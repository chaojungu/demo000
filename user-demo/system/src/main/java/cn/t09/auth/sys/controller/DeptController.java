package cn.t09.auth.sys.controller;

import cn.demo.domain.TreeNode;
import cn.t09.auth.sys.entity.Dept;
import cn.t09.auth.sys.service.IDeptService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.t09.demo.common.controller.BaseController;
import com.t09.demo.common.domain.AjaxResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
 * 部门管理 前端控制器
 * </p>
 *
 * @author t09
 * @since 2019-06-12
 */

@Controller
@RequestMapping("/sys/depts")

public class DeptController extends BaseController {

    @Resource
    private IDeptService deptService;

    @GetMapping("{deptId}")
    @ResponseBody
    public AjaxResult getById(@PathVariable Long deptId) {
        Dept dept = deptService.getById(deptId);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, dept);
    }

    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestBody Dept dept) throws Exception {
        deptService.save(dept);
        return AjaxResult.ok();
    }

    @PutMapping
    @ResponseBody
    public AjaxResult update(@RequestBody Dept dept) throws Exception {
        deptService.updateById(dept);
        return AjaxResult.ok();
    }

    @DeleteMapping
    @ResponseBody
    public AjaxResult delete(@RequestBody List<Long> deptIds) throws Exception {

        deptService.removeByIds(deptIds);
        return AjaxResult.ok();
    }

    @GetMapping
    @ResponseBody
    public AjaxResult list(@RequestParam(value = "page", defaultValue = "1") Long pageIndex,
        @RequestParam(value = "rows", defaultValue = "5") Long pageSize,
        Dept dept) {
        IPage<Dept> page = new Page<>(pageIndex, pageSize);
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>(dept);
        deptService.page(page, queryWrapper);
        return AjaxResult.ok().put("data", page);
    }

    @GetMapping("/tree")
    @ResponseBody
    public Object listByTree(Dept dept) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>(dept);
        List<Dept> deptList = deptService.list(queryWrapper);
        return getChildrenListFromDeptList(0L, deptList);
    }

    private List<TreeNode> getChildrenListFromDeptList(Long parentId,
        List<Dept> deptList) {
        List<TreeNode> treeNodes = new ArrayList<>();

        Iterator<Dept> deptIterator = deptList.iterator();
        while (deptIterator.hasNext()) {
            Dept dept = deptIterator.next();
            if (dept.getParentId().equals(parentId)) {
               deptIterator.remove();
               treeNodes.add(convertorDeptToTreeNode(dept));
            }
        }
        for (TreeNode treeNode : treeNodes) {
            treeNode.setChildren(getChildrenListFromDeptList(treeNode.getId(),deptList));
        }
        return treeNodes;
    }


    private TreeNode convertorDeptToTreeNode(Dept dept) {
        TreeNode treeNode = new TreeNode();
        treeNode.setId(dept.getDeptId());
        treeNode.setText(dept.getName());
        return treeNode;
    }

}
