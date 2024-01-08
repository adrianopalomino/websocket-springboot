Websocket Example - Readme Este é um exemplo simples de aplicação Spring Boot com WebSocket. O projeto demonstra como criar uma comunicação bidirecional entre o servidor e os clientes usando WebSocket.

Instruções para Teste: Rodar o Projeto: Certifique-se de ter o Maven instalado e execute o seguinte comando para iniciar o aplicativo Spring Boot:

Abra o arquivo web-socket.html em seu navegador.

Enviar Notificação: No HTML, clique no botão "Enviar Notificação". Isso enviará uma mensagem WebSocket para o servidor, que será transmitida aos clientes conectados.

Chamar o Endpoint via HTTP: Abra um navegador ou use uma ferramenta de API (como Postman) para chamar o seguinte endpoint:

bash Copy code http://localhost:8080/api/data/update/param4 Certifique-se de substituir "param4" pelo valor desejado.

Verificar Console do Navegador: Observe o console do navegador (abrindo o console do desenvolvedor) para ver as mensagens WebSocket e notificações recebidas.
