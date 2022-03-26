public class Util {
    public static String[] separateFileNameAndExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            String fileNameWithoutExtension = fileName.substring(0, dotIndex);
            String extension = fileName.substring(dotIndex + 1);
            return new String[]{fileNameWithoutExtension, extension};
        }

        return new String[]{fileName, null};
    }
}
