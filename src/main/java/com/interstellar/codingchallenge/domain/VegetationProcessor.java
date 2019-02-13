package com.interstellar.codingchallenge.domain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Service;

import com.interstellar.codingchallenge.domain.Granule.Bands;
import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

@Service
public class VegetationProcessor implements ImageProcessor {

  @Override
  public byte[] process(Granule granule) throws NotEnoughImages, IOException {
    if (!granule.has(Bands.B05) || !granule.has(Bands.B06) || !granule.has(Bands.B07)) {
      throw new NotEnoughImages();
    }

    File vrt = File.createTempFile("gdal", ".vrt");
    File jpg = File.createTempFile("gdal", ".jpg");

    int result = 0;
    String cmd1 = "gdalbuildvrt -separate " + vrt.getAbsolutePath() + " " + granule.get(Bands.B05) + " "
        + granule.get(Bands.B06) + " " + granule.get(Bands.B07);
    String cmd2 = "gdal_translate -scale 0 16000 0 255 -exponent 0.5 -ot Byte -of jpeg " + vrt.getAbsolutePath() + " "
        + jpg.getAbsolutePath();
    try {
      Runtime runtime = Runtime.getRuntime();
      result = runtime.exec(cmd1).waitFor();

      if (result == 0) {
        result = runtime.exec(cmd2).waitFor();
      }
    } catch (InterruptedException | IOException e) {
      result = 0;
    }
    if (result != 0) {
      throw new NotEnoughImages();
    }

    byte[] res = Files.readAllBytes(jpg.toPath());

    vrt.delete();
    jpg.delete();

    return res;
  }
}
