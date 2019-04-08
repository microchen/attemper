package com.sse.attemper.scheduler.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sse.attemper.common.constant.APIPath;
import com.sse.attemper.common.param.scheduler.TriggerChangedParam;
import com.sse.attemper.common.result.CommonResult;
import com.sse.attemper.scheduler.handler.TriggerUpdatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriggerUpdatedController {

    @Autowired
    private TriggerUpdatedService handler;

    @PutMapping(APIPath.SchedulerPath.TRIGGER)
    public CommonResult<Void> updateTrigger(@RequestBody TriggerChangedParam param) throws JsonProcessingException {
        return CommonResult.putResult(handler.updateTrigger(param));
    }
}
