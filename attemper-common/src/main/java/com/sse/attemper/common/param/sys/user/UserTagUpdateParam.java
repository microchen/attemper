package com.sse.attemper.common.param.sys.user;

import com.sse.attemper.common.enums.TagType;
import com.sse.attemper.common.param.CommonParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @author ldang
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTagUpdateParam implements CommonParam {

    protected String userName;

    protected String[] tagNames;

    protected Integer tagType;

    public String validate() {
        if (StringUtils.isBlank(userName)) {
            return "5200";
        }
        boolean tagNameNull = (tagNames == null || tagNames.length == 0);
        boolean tagTypeNull = (tagType == null);
        if(!tagTypeNull){
            if(tagNameNull) {
                return "5300";  //有标签类型而无标签名称
            }else if(TagType.get(tagType) == null){
                return "5321";  //有标签类型和标签名称时，标签类型不符要求
            }
        }else if (!tagNameNull){
            return "5321";  //无标签类型但有标签名称
        }
        return null;
    }

}
