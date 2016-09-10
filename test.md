Here are a few simple tests:
```
$ java -jar dist/wordfind.jar ~/word.list 3 2 " e e b" | shasum
1a619cb2ae956c8d75362eb775928e664f9cb482  -
$ java -jar dist/wordfind.jar src/word.list 4 4 serspatglinesers | shasum
06fe011a568b53394b6820692daab70ec305a60b -
$ java -jar dist/wordfind.jar ~/word.list 4 4 "se spatglin se s" | shasum
318df4aa741efed4a8488cb2bbb1437c77d3e359  -
$ java -jar dist/wordfind.jar ~/word.list 5 5 rsclsdeiaegntrpiaesolmidc | shasum
25f4e8c993230707ec7b65ed0a2a457d106681aa -
```