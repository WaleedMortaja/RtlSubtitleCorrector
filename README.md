# RtlSubtitleCorrector
##About
When writing Right-to-Left content inside Left-To-Right context, it is usually mis-represented.
This happens specially with subtitles.
This project fixes this issue by inserting a Right-To-Left isolation character `\u2067` before and after every Left-To-Right sentences.

## Usage
Open cmd or terminal. Run the `jar` file followed by file path:

    RtlSubtitleCorrector.jar mysubtitle.srt
Note: You can enter multiple files at once.

    RtlSubtitleCorrector.jar mysubtitle1.srt mysubtitle2.srt
For linux Systems, You can use it as:

    ./RtlSubtitleCorrector.jar mysubtitle.srt

# See also
- [Wikipedia Bidirectional_text](https://en.wikipedia.org/wiki/Bidirectional_text)
- [A similar project](https://github.com/Majid110/SubtitleRtlCorrector)