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
import org.system.admin.model.User;

public interface EmailService {
    void sendPendingAcceptanceEmail(User seller);
    void sendPendingRejectEmail(User seller);
//    void sendPendingAcceptanceReview(User buyer, Review review);
//    void sendPendingRejectReview(User buyer, Review review);
}
