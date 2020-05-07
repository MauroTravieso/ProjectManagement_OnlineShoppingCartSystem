package org.system.email;
/**
 *  Service
 *
 * Bugs: none known
 *
 * @author       Dinh Nguyen (986520) - Team II APR2020
 * @version      1.0
 *
 */
public class EmailConstants {
    final public static String EMAIL_ACCEPT_SUBJECT = "[Seller Account approved]";
    final public static String EMAIL_ACCEPT_TEXT_START = "Dear Mr ";
    final public static String EMAIL_ACCEPT_TEXT_END = " ,\n\nCongratulations, your seller account have been approved :)";

    final public static String EMAIL_REJECT_SUBJECT = "[Seller Account rejected]";
    final public static String EMAIL_REJECT_TEXT_START = "Dear Mr ";
    final public static String EMAIL_REJECT_TEXT_END = " ,\n\nWe are so sorry, your seller account have been rejected :(";
}
