package com.sse.attemper.common.param.dispatch.job;

import com.sse.attemper.common.param.PageSortParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ldang
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseJobListParam extends PageSortParam {

    protected String jobName;

    protected String displayName;

    protected List<Integer> status;
}
