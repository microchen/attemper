package com.sse.attemper.common.param.sys.tag;

import com.sse.attemper.common.param.PageSortParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagListParam extends PageSortParam {

    protected String tagName;

    protected String displayName;

}
