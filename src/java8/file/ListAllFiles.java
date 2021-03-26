package java8.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListAllFiles {

    private static final String COMMON = "D:\\taipower\\dev2\\windows\\";

    private static final String FOLDER_A = "taipower-api\\lib\\";
    private static final String FOLDER_B = "taipower-intranet\\lib\\";
    private static final String FOLDER_C = "common\\lib\\";
    private static final String FOLDER_D = "member-auth-server\\lib\\";
    private static final String FOLDER_E = "member-resource-server\\lib\\";
    private static final String FOLDER_F = "member-account-collector\\lib\\";

    private static void fileWalk(String folder) {
        try (Stream<Path> walk = Files.walk(Paths.get(folder))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());

            System.out.println(folder.replace(COMMON, "").replace("\\lib\\", "") + ":");
            System.out.println("");

            result.forEach(r -> System.out.println(r.replace(folder, "")));
            System.out.println("");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ListAllFiles.fileWalk(COMMON + FOLDER_A);
        ListAllFiles.fileWalk(COMMON + FOLDER_B);
        ListAllFiles.fileWalk(COMMON + FOLDER_C);
        ListAllFiles.fileWalk(COMMON + FOLDER_D);
        ListAllFiles.fileWalk(COMMON + FOLDER_E);
        ListAllFiles.fileWalk(COMMON + FOLDER_F);

    }
}
