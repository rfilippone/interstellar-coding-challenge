package com.interstallar.codingchallenge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.RequestMethod;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CodingChallengeApplicationTests {

  @Autowired
  private WebTestClient webClient;

  @Test
  public void returns404OnWrongURI() {
    this.webClient.get().uri("/").exchange().expectStatus().isNotFound();
  }

  @Test
  public void returns404OnWrongMethod() {
    this.webClient.get().uri("/generate-images").exchange().expectStatus().isEqualTo(HttpStatus.METHOD_NOT_ALLOWED)
        .expectHeader().valueEquals(HttpHeaders.ALLOW, RequestMethod.POST.name());
  }
}
