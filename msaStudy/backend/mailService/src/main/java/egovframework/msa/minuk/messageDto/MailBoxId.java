package egovframework.msa.minuk.messageDto;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;

@Getter
public class MailBoxId implements Serializable {
    private String userID;
    private int mailIndex;

    public MailBoxId() {}

    public MailBoxId(String userID, int mailIndex) {
        this.userID = userID;
        this.mailIndex = mailIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MailBoxId)) return false;
        MailBoxId that = (MailBoxId) o;
        return mailIndex == that.mailIndex && Objects.equals(userID, that.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, mailIndex);
    }
}