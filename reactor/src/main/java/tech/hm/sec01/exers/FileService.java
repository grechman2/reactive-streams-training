package tech.hm.sec01.exers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import reactor.core.publisher.Mono;
import tech.hm.courceutils.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {

    public static void main(String[] args) {
        createFile("test123.txt", "Hello world")
                        .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        readFile("/tmp/test123.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        deleteFile("/tmp/test123.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }

    private static Mono<Boolean> deleteFile(String path) {
        return Mono.fromSupplier(()->{
            try {
                Files.delete(Path.of(path));
                return true;
            } catch (IOException e) {
                throw new RuntimeException(ExceptionUtils.getStackTrace(e));
            }
        });
    }

    private static Mono<String> readFile(String path) {
        return Mono.fromSupplier(()-> {
            try {
                return Files.readString(Path.of(path));
            } catch (IOException e) {
               throw new RuntimeException(ExceptionUtils.getStackTrace(e));
            }
        });
    }

    public static Mono<String> createFile(String fileName, String content) {
        return Mono.fromSupplier(() -> {
            System.out.println("start writing");
            Path file = null;
            try {
                file = Files.createFile(Path.of("/tmp", fileName));
                Files.writeString(file, content);
                return file.toFile().getAbsolutePath();
            } catch (IOException e) {
                throw new RuntimeException(ExceptionUtils.getStackTrace(e));
            }
        });
    }


}
