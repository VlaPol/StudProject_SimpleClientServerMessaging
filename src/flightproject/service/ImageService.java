package flightproject.service;

import flightproject.util.PropertiesUtil;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;


import static java.nio.file.StandardOpenOption.*;
import static lombok.AccessLevel.*;

@NoArgsConstructor(access = PRIVATE)
public class ImageService {

    private static final ImageService INSTANCE = new ImageService();

    private final String basePath = PropertiesUtil.get("image.base.url");

    @SneakyThrows
    public void upload(String imagePath, InputStream imageContent){
        var imageFullPath = Path.of(basePath, imagePath);
        try(imageContent){
            Files.createDirectories(imageFullPath.getParent());// if not exist
            Files.write(imageFullPath, imageContent.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        }

    }

    public static ImageService getInstance(){
        return INSTANCE;
    }

    // for different files size
    @SneakyThrows
    public Optional<InputStream> get(String imagePath) {

        var imageFullPath = Path.of(basePath, imagePath);

        return Files.exists(imageFullPath) ? Optional.of(Files.newInputStream(imageFullPath))
                : Optional.empty();
    }
}
