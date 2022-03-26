import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            printHelp(System.out);
            System.exit(0);
        }

        for (String inputFilePathString : args) {
            Path currentWorkingDirectory = Path.of(System.getProperty("user.dir"));
            Path inputFilePath = Path.of(inputFilePathString);
            inputFilePath = currentWorkingDirectory.resolve(inputFilePath);

            String fileContent = null;
            try {
                fileContent = Files.readString(inputFilePath);
            } catch (IOException e) {
                System.out.println("ERROR: Could not read file!");
                System.exit(1);
            }

            String[] inputFileNameAndExtension = Util.separateFileNameAndExtension(inputFilePath.getFileName().toString());

            String fixedFileContent = RtlSubtitleCorrector.correctRtl(fileContent, inputFileNameAndExtension[1]);

            if (inputFileNameAndExtension[1] == null) {
                inputFileNameAndExtension[1] = "txt";
            }

            String outputParent = inputFilePath.getParent().toString();
            String outputFileName = inputFileNameAndExtension[0] + ".RTL." + inputFileNameAndExtension[1];

            try {
                Files.writeString(Path.of(outputParent, outputFileName), fixedFileContent);
            } catch (IOException e) {
                System.out.println("ERROR: Could not write file!");
                System.exit(1);
            }
        }

    }

    private static void printHelp(PrintStream out) {
        out.println("Please specify the input file path\n" +
                "Example:\n" +
                "RtlSubtitleCorrector.jar mysubtitle.srt\n\n" +
                "Note: You can enter multiple files at once\n" +
                "Example:\n" +
                "RtlSubtitleCorrector.jar mysubtitle1.srt mysubtitle2.srt\n\n" +
                "For linux Systems, You can use it as:\n" +
                "./RtlSubtitleCorrector.jar mysubtitle.srt");
    }


}
