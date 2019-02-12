package com.interstellar.codingchallenge.domain;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.interstellar.codingchallenge.domain.exception.NotEnoughImages;

@Service
public class GranuleFinder {

  private String dataFolder;

  public GranuleFinder(@Value("${data_folder}") String dataFolder) {
    this.dataFolder = dataFolder;
  }

  public Granule findGranule(final ImageGenerationRequest request) throws NotEnoughImages {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    final String regex = "T" + request.getUtmZone() + request.getLatitudeBand() + request.getGridSquare() + "_"
        + sdf.format(request.getDate()) + "T(.+?)_B\\d\\d.tif";
    final Pattern pattern = Pattern.compile(regex);

    File dir = new File(dataFolder);
    File[] files = dir.listFiles(new FileFilter() {
      @Override
      public boolean accept(File pathname) {

        Matcher matcher = pattern.matcher(pathname.getName());
        if (matcher.find()) {
          return true;
        }
        return false;
      }
    });

    Map<String, List<File>> groups = Arrays.stream(files)
        .collect(Collectors.groupingBy(file -> file.getName().substring(16, 22)));

    if (groups.entrySet().size() == 0) {
      throw new NotEnoughImages();
    }

    return Granule.fromfiles(groups.entrySet().stream().findFirst().get().getValue());
  }

}
