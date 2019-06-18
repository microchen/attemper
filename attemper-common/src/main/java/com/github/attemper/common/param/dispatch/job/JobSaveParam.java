package com.github.attemper.common.param.dispatch.job;

import com.github.attemper.common.enums.JobStatus;
import com.github.attemper.common.param.CommonParam;
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
public class JobSaveParam implements CommonParam {

    protected String jobName;

    protected String displayName;

    protected String jobContent;

    protected Integer status;

    protected Integer timeout;

    protected Boolean concurrent;

    protected String remark;

    public String validate() {
        if (StringUtils.isBlank(jobName)){
            return "6000";
        }
        if (StringUtils.isBlank(displayName)){
            return "6003";
        }
        if (JobStatus.get(status) == null) {
            return "6004";
        }
        return null;
    }

    @Override
    public void preHandle() {
        if (concurrent == null) {
            concurrent = false;
        }
    }
}
