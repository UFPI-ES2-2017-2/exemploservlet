# Exemploservlet
Aplicação java web padrão maven implementada com servlets e controle de sessão.

<p>Esta aplicação implementa as seguintes fucionalidades utilizando o padrão de chamadas via request e response usando servlets:</p>
<ul>
<li>Controle de sessão de usuário (login/logout)</li>
<li>Lista de usuários privada</li>
<li>Lista de usuários pública em formato JSON</li>
<li>Consulta de usuário por tipo de atributo</li>
<li>Upload de arquivos privado</li>
</ul>

<p>A estrutura da aplicação é organizada em camadas. Foi convencionado que cada novo servlet atende a um serviço específico e é colocado no pacote de serviços.</p>

<p>As seguintes dependências são usadas nesta aplicação:</p>
<ul>
  <li>Gson - para serialization/deserialization do JSON.</li>
  <li>Commons-fileupload - para controle de upload de arquivos.</li>
</ul>
