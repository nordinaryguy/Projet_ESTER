\section{Base de Données}

\subsection{Choix}

\subsubsection{Besoin}

Pour le projet, nous avons eu besoin d'une base de données modulaire car un des besoins était que les questionnaires pouvait évoluer création, modification ou ajout de question. Et un autre des besoins était que l'utilisateur puisse faire des sauvegarde partiel pour reprendre le questionnaires en case de problème ou si l'utilisateur veut faire une pause. 

En plus des besoins spécifique pour la sauvegarde des questionnaires et des réponses. Il y a des besoins plus génériques comme la gestion des comptes que nous verrons plus en détails dans un autre partie.

\subsubsection{NoSQL: MongoDB}

Nous somme partie sur du MongoDB qui fais partie de la mouvance NoSQL qui s'écarte du paradigme classique des bases relationnelles. Cela nous permet de nous affranchir d'une des contraintes des base de données SQL qui est de devoir définir un schéma prédéfini. Nous somme quand même partie d'un schéma de base pour avoir des données en partie structurée.

En offrant un plus grande flexibilité en permettant de gérer des données hétérogènes. Dans cas cela est particulièrement utile pour les questionnaires et les réponses car si un questionnaires est modifier, il faut que les anciens réponses reste en parti utilisable.

\begin{figure}[H]
    \begin{center}
    \includegraphics[height=2.0cm]{img/mongodb}
    \end{center}
    \caption{Logo de MongoDB}
\end{figure}

Ce choix du type de la base de données a été proposer par nos chefs de projet. La raison du choix de MongoDB est car il est le membre le plus populaire de la famille NoSQL.   

\subsection{Implémentation}

\subsubsection{MongoDB}

Pour l'implémentation nous avons utilisé le driver officiel proposer par MongoDB pour le Java. Nous avons crée un classe en Java qui nous héritons et que permet des interfaces pour simplifier l'utilisation dans le reste du code.

Nous avons deviser en trois partie, une première "Utilisateur" qui contient les information sur les comptes (Entreprise, Salarie et Utilisateur Ester).

Un autre "Questionnaires" (ID du questionnaire, ID de celui qui la soumis, Date de création, HTML du questionnaire). 

Et enfin la partie "Réponses" (ID du question, ID de celui qui a répondus, réponses (ID question, réponse)). La modélisation de la parti "Utilisateur" correspond à celle fournis par les M2.

\subsubsection{Chiffrement des mots de passe}

Car nous stockons des mots de passe dans la base de données, nous avons eu besoin de sécuriser les mots de passe pour ne pas les stocker en clair.

Nous avons comparé plusieurs technologies MD5, SHA256, SHA512, PBKDF2, BCrypt et SCrypt. Ce sont tous des fonctions de hachage mais certaine propose de base le salage (PBKDF2, BCrypt, SCrypt) qui permet de ce protéger contre les attaques utilisant des rainbow tables ou par dictionnaire. 

Certaine fonction de hachage sont difficilement optimisable ce qui permet de rendre plus difficile les attaques par brute force ce qui permettra de donné le temps a l'utilisateur de changer sont mots de passe.     

Nous avons choisi d'utilisé BCrypt car il propose un implémentation en java et il fais parti des plus sécuriser de algorithme.

\subsection{Bilan}

La base de données est fonctionnel, mais la parti enregistrement questionnaires n'est pas optimal, faute de temps nous enregistrons le code HTML du questionnaire en dur. 

Comme nous ne stockons pas les questionnaires en structure qui nous permettrais de récupéré la liste des questions et des réponses possible. Cela nous empêche aussi de récupéré les réponses pour préremplir le questionnaire si l'utilisateur quitte l'application. Actuellement, il n'y a pas de calcule de score mais seulement celui du pourcentage de personne qui on répondus.
