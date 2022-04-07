package wsy0414.usermanagment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class UserInfo {
    int userId;

    @NonNull
    String userName;

    @NonNull
    String pwd;

    String eMail;

    String birthday;
}
