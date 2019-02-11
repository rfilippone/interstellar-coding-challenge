package com.interstellar.codingchallenge;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.RequestMethod;

import com.interstellar.codingchallenge.domain.ImageGenerationRequest;
import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

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
  public void returns405OnWrongMethod() {
    this.webClient.get().uri("/generate-images").exchange().expectStatus().isEqualTo(HttpStatus.METHOD_NOT_ALLOWED)
        .expectHeader().valueEquals(HttpHeaders.ALLOW, RequestMethod.POST.name());
  }

  @Test
  public void returns404OnMissingImages() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ImageGenerationRequest request = new ImageGenerationRequest(33, "U", "UP", sdf.parse("1990-01-01"), "visible");

    this.webClient.post().uri("/generate-images").contentType(MediaType.APPLICATION_JSON_UTF8).syncBody(request)
        .exchange().expectStatus().isEqualTo(HttpStatus.NOT_FOUND).expectBody()
        .jsonPath("message", NotEnoughImages.MESSAGE);
  }

}
