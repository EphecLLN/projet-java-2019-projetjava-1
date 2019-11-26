# Cahier des charges

## Contexte du projet
La haute école “1Formatik” reçoit de plus en plus de retours négatifs, de la part du personnel, sur la qualité de l’équipement de ses locaux. En effet, les professeurs se plaignent de la dégradation du matériel et pensent que la haute-école néglige l’entretien de celui-ci.
La haute-école répond qu’elle ne néglige pas l’entretien du matériel mais qu’aucun système de communication lié à la dégradation de l’équipement n’a été mis au point.
De ce fait, elle n’arrive pas à gérer de manière efficace l’entretien de son matériel.

## Objectif du projet
La haute école souhaite une solution applicative qui répertorie, de manière centralisée, le matériel disponible, ainsi que son état, dans l’ensemble de ses locaux au sein de toutes ses antennes.

## Contraintes techniques
Ce programme doit être développé en Java. Cette solution sera destinée à être installée sur les différents PC des établissements de l’école.

## Description des besoins fonctionnels
l y aura différents niveaux d’utilisateurs et donc d’accessibilité sur l’application :
- Un utilisateur classique (ex: professeur) : aura accès uniquement à l’état du matériel dans l’antenne pour laquelle il travaille. Et pourra faire une déclaration de dégradation d’un matériel.
- Un utilisateur spécialiste informatique (ex : équipe informatique d’une antenne) : même accès que l’utilisateur classique mais en plus il aura accès à la modification de l’état d’un matériel.
- Un utilisateur gérant (ex: économe de l’antenne) : même accès et droit que le spécialiste informatique mais s’occupe en même temps de la modification des états du matériel de son antenne.

### fonctionnalités

- Afficher l’état de l’équipement :
  - Au niveau d’un local
  - Au niveau d’une antenne
  - Au niveau global
- Déclarer la dégradation de l’état d’un équipement
