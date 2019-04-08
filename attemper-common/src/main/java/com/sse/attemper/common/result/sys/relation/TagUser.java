package com.sse.attemper.common.result.sys.relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 标签与用户的关系
 * @author ldang
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagUser {

	protected String tagName;

	protected String tagType;

	protected String userName;

	protected String tenantId;

}