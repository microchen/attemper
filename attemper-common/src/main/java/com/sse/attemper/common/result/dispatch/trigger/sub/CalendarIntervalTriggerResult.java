package com.sse.attemper.common.result.dispatch.trigger.sub;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalendarIntervalTriggerResult extends CommonTriggerResult {

    protected int interval = 1;

    protected String timeUnit;

    protected int repeatCount = -1;

    protected boolean preserveDayLight;

    protected boolean skipDayIfNoHour;

    protected String timeZoneId;

}
