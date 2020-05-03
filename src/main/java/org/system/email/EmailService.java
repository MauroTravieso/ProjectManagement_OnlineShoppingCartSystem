package org.system.email;


import org.system.admin.model.User;

public interface EmailService {
    void sendPendingAcceptanceEmail(User seller);
    void sendPendingRejectEmail(User seller);
//    void sendPendingAcceptanceReview(User buyer, Review review);
//    void sendPendingRejectReview(User buyer, Review review);
}
