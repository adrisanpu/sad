# sad

https://www.pythonmania.net/es/2009/05/21/threads-en-pygtk/

REPOSITORI DE L'ASSIGNATURA SOFTWARE APLICACIONS DISTRIBUIDES:

AUTORS:
- Joan Plana Sala
- Adrià Sánchez Puig

DUBTES PRÒXIMA CONSULTA:
- Chat: els sockets que s'accepten al tester del server, es connecten els stdout i stdin pero a l'hora de fer el mètode getNick() retorna null o string buit. S'ha de fer un enviament previ del nick en un misstage o es pot utilitzar el mètode.
      -> Els sockets del servidor i client no son els mateixos, per tant a un socket del servidor no se li pot fer el getNick(), el q s'ha de fer es passar com a
         el nom, i posteriorment emmagatzemar-lo.
         
- Chat: el map del server amb nick, socket lo de exclusió mútua ha de ser perque cada thread dels clients pugui accedir a modificar els seus valors: afegir entry, eliminar entry i res més no?
      -> si
      
- SortAlgoVis: no se ven bé com encarar el tema dels threads, perqué les funcions que vull que facin de "run" dels threads son alhora també les funcions update del observer. Quina funció declaro com a thread principal i quina com a thread auxiliar. Quan s'inicia el thread auxiliar es para automaticament el principal i després haig de fer un  join? 

- SortAlgoVis: es podria fer amb interrupcions en comptes de threads

---------------------------------

PROPOSTA IMPLEMENTACIÓ:
- SortAlgoVis: Com que estem tenint problemes amb la sincroització del cssProvider de gtk, podem enfocar-nos a implementar una vista en terminal executant diferentes sequències de escape xterm i després ja inetenterem acabarem la vista gtk si hi ha temps.

- Chat: Crec que hem de fer que el thread de serverThread sigui el output thread pero del client. Ens interessa que el client també pugui veure el que ara sen's imprimeix al servidor.
