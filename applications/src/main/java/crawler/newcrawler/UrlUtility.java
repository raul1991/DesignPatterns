package crawler.newcrawler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlUtility {
    private static Pattern hrefPattern = Pattern.compile("href=\"(?<link>\\S+)\"");
    private static Pattern blobPattern = Pattern.compile("\\.[a-zA-Z0-9]+$");

    private UrlUtility() {}

    public static String replaceTrailingSlash(String linkToFollow) {
        char lastChar = linkToFollow.charAt(linkToFollow.length() - 1);
        return lastChar == '/' ? linkToFollow.substring(0, linkToFollow.length() - 1) : linkToFollow;
    }

    public static boolean isFollowableLink(String linkToFollow)
    {
        return !isNotBlankOrSelf(linkToFollow)
                && isRelativeUrl(linkToFollow)
                && !isABlobLink(linkToFollow);
    }

    public static boolean isNotBlankOrSelf(String link)
    {
        return link.trim().isEmpty() || link.equals("/") || link.startsWith("#");
    }

    public static boolean isABlobLink(String link)
    {
        return !link.endsWith(".") && blobPattern.matcher(link).find();
    }

    public static boolean isRelativeUrl(String link)
    {
        return !link.startsWith("//") && link.startsWith("/");
    }

    public static boolean isSubdomain(String link, String website)
    {
        return (link.startsWith("http") || link.startsWith("https")) && link.endsWith(website);
    }

    public static Matcher getMatcher(String line)
    {
        return hrefPattern.matcher(line);
    }

    public static String getMatcherGroup(Matcher matcher) {
        return matcher.group("link");
    }
}
