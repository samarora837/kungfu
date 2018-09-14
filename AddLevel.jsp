
   
    <%String message1 =  (String)request.getAttribute("message"); %>
     
      <h2>Please enter below details to add new Level</h2>
      
      <div id="studentdiv">
      <div id="result" style="color:green"><% if(message1 != null){%> <%=message1%> <%}%></div>
        <form id="levelForm" action="addlevel" method="GET">
        <div id= "addLevel">
        <table>
        <tr>
         	<td ><label for="levelname">Level Name</label></td>
            <td ><input type="text" name="levelname" id="levelname" value="" size="22" required/></td>
          </tr>
          <tr>
            <td><label for="classStarttime">Class Start Time</label></td>
            <td ><input type="text" name="classStarttime" id="classStarttime" value="" size="22" required/></td>
          </tr>
          <tr>
            <td><label for="classEndtime">Class End Time</label></td>
            <td ><input type="text" name="classEndtime" id="classEndtime" value="" size="22" required/></td>
          </tr>
          <tr>
          <td></td>
           
            <td><input name="submit" type="submit" id="submit" value="Submit" /></td>
          </tr>
          </table>
          </div>
        </form>
      </div>


