public class RtlSubtitleCorrector {
    private final static char RTL_CHAR = '\u2067';
    private final static String LTR_REGEX = "[\\p{IsLatin}\\p{P}]+";

    public static String correctRtl(String text, String fileExtension) {
        if (fileExtension == null) {
            return defaultRtlCorrection(text);
        }

        String fixedText = null;
        switch (fileExtension) {
            case "ssa":
                fixedText = text.replaceAll("(\\\\[nN])", RTL_CHAR + "$1" + RTL_CHAR);
                fixedText = fixedText.replaceAll("(Dialogue: (?:[^,]*,){9})(.*)", "$1" + RTL_CHAR + "$2");
                break;
            default:
                fixedText = defaultRtlCorrection(text);
                break;
        }
        return fixedText;
    }

    private static String defaultRtlCorrection(String text) {
        return text.replaceAll("(" + LTR_REGEX + ")", RTL_CHAR + "$1" + RTL_CHAR);
    }
}
