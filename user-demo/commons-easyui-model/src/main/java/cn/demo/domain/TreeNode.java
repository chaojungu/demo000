package cn.demo.domain;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by gcjun on 2019/6/15.
 */
@Data
public class TreeNode {
    private Long id;
    private String text;
    private String state="open";
    private List<TreeNode> children;
    private Boolean checked;
    private String iconCls;
    private Map<String,Object> attributes;
}
