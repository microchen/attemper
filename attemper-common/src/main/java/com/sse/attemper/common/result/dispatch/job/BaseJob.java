package com.sse.attemper.common.result.dispatch.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ldang
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseJob {

    protected String jobName;

    protected String displayName;

    protected String jobContent;

    protected Integer status;

    protected Integer maxReversion;

    protected Integer maxVersion;

    protected Integer reversion;

    protected Integer version;

    protected Date createTime;

    protected Date updateTime;

    protected Date deploymentTime;

    protected String remark;

    protected String tenantId;

}
