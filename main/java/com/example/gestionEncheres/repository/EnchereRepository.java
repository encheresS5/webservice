package com.example.gestionEncheres.repository;
import com.example.gestionEncheres.models.Enchere;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EnchereRepository extends JpaRepository<Enchere,Integer> {
    @Query(value = "select utilisateurs.nom from encheres join utilisateurs on encheres.idutilisateur=utilisateurs.idutilisateur where encheres.idutilisateur=:idUtilisateur and encheres.idEnchere=:idEnchere",nativeQuery = true)
    public String isMine(@Param("idUtilisateur") Integer idUtilisateur, @Param("idEnchere") Integer idEnchere);

    @Transactional
    @Modifying
    @Query(value = "insert into encheres values (default,:idutilisateur,:idproduit,:description,:prix_min_enchere,:duree,default)",nativeQuery = true)
    public void addEnchere(@Param("idutilisateur") Integer idutilisateur, @Param("idproduit") Integer idproduit, @Param("description") String description, @Param("prix_min_enchere") Integer prix_min_enchere, @Param("duree") Integer duree);

//    @Query(value = "select * from encheres join produits on encheres.idproduit = produits.idproduit :condition",nativeQuery = true)
//    public List<Enchere> rechercher(@Param("condition") String condition);

    @Query(value = "select * from encheres where idutilisateur=:id order by dateenchere desc", nativeQuery = true)
    public List<Enchere> getMyBids(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update encheres set statut=true where idenchere=:idenchere",nativeQuery = true)
    public int setFinished(@Param("idenchere") Integer IdEnchere);

    @Query(value = "select * from encheres where statut='f'", nativeQuery = true)
    public List<Enchere> getListEnchereNonFinished();

    @Query(value = "select * from encheres where idutilisateur=:idUtilisateur and statut='t' order by dateenchere asc", nativeQuery = true)
    public List<Enchere> getListEnchereHistorique(@Param("idUtilisateur") int idUtilisateur);
}
