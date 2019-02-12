package com.interstellar.codingchallenge.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = ChannelMapUnsupported.MESSAGE)
public class ChannelMapUnsupported extends Exception {
  public static final String MESSAGE = "Unsupported channelMap value";
}
