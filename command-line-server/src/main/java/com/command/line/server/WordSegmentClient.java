package com.command.line.server;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.service.core.api.IWordSegment;

@FeignClient(name = "WORD-SEGMENT-SERVER")
public interface WordSegmentClient extends IWordSegment {

}