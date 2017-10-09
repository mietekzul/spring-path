package pl.raziel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.raziel.entity.UserInfo;

@Repository
@Transactional
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    UserInfo findByUserNameAndEnabledIs(String userName, short enabled);

    UserInfo findByUserName(String userName);
}