package NoCountry.YouTech.repository;

import NoCountry.YouTech.projection.IPContentCreator;
import NoCountry.YouTech.dto.contentCreator.ContentCreatorResponseDTO;
import NoCountry.YouTech.model.ContentCreator;
import NoCountry.YouTech.projection.IPContentCreatorForEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentCreatorRepository extends JpaRepository<ContentCreator, Integer> {
    @Query("SELECT c.idContentCreator as idContentCreator,user.email as email, c.name as name,c.lastName as lastName,c.imageProfile as imageProfile ,user.isAdmin as isAdmin FROM ContentCreator c JOIN c.idUser user WHERE user.email=:email")
    IPContentCreator findByEmail(String email);

    @Query("SELECT c.name as name,c.lastName as lastName,c.urlGithub as urlGithub,c.urlTwitter as urlTwitter, c.urlLinkedin as urlLinkedin, c.idPseudonym as pseudonym ,user.email as email, user.password as  password,c.nameImageProfile as  nameImageProfile, c.imageProfile as imageProfile FROM ContentCreator c JOIN c.idUser user WHERE c.idContentCreator=:idContentCreator")
    IPContentCreatorForEdition findForEdition(Integer idContentCreator);

    public List<ContentCreatorResponseDTO> findLikeName(String name);

    public List<ContentCreatorResponseDTO> findLikeLastName(String name);
}
