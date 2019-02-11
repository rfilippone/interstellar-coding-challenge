package com.interstellar.codingchallenge.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = NotEnoughImages.MESSAGE)
public class NotEnoughImages extends Exception {
  public static final String MESSAGE = "No images found for the requested input";
}
