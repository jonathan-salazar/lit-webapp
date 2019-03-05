<%-- 
    Document   : advanced-search.jsp
    Created on : Feb 12, 2019, 11:47:20 AM
    Author     : Johnny
--%>

Hi welcome to the advanced search page

<div id="nav">
    <ul>
      <li><a href="/index">Home</a></li>
      <li><a href="/new-lit-item">Create New Item</a></li>
      <li><a href="/search">Search</a></li>
      <li><a href="/advanced-search">Advanced Search</a></li>
      <li><a href="/lit-item-details">View All Item Details</a></li>

    </ul>
</div>

<form action="/search-results" method="GET">
    Investor Com Id (Current Code):
    <input name="investor-com-id" type="text">
    Investor Com Id (Old Code):
    <input name="investor-com-id-old" type="text">
    Old Code in use?
    <input name="old-in-use" type="checkbox">
    <br><br>
    Title:
    <input name="title" type="text">
    Language Version:
    <select name="language-version-list">
        <option value="EN">EN (English)</option>
        <option value="FR">FR (French)</option>
    </select>
    <br>

    Delivery Type:
    <select name="delivery-type-list">
        <option value="EL">Email</option>
        <option value="PT">Print</option>
        <option value="BR">Brochure</option>
    </select>
    <br>

    Series Specific:
    <input name="series-specific" type="text">
    <br>

    Active:
    <input name="active" type="checkbox">
    <br>

    Rebranded:
    <select name="rebranded-list">
        <option value="Y">Yes</option>
        <option value="N">No</option>
        <option value="n/a">N/A</option>
    </select>
    <br>

    Content Type:
    <input name="content-type" type="text">

    Frequency:
    <select name="frequency-list">
        <option value="Annual">Annual</option>
        <option value="Monthly">Monthly</option>
        <option value="One-Time">One-Time</option>
        <option value="Quarterly">Quarterly</option>
        <option value="Semi-Annual">Semi-Annual</option>
        <option value="n/a">N/A</option>
    </select>
    <br>

    On-Web <input name="on-web" type="checkbox">
    MERs <input name="mers" type="checkbox">
    Results <input name="results" type="checkbox">
    PM Years of Exp. <input name="pm-years-of-exp" type="checkbox">
    Annual Stats <input name="annual-stats" type="checkbox">
    Capital Advantage <input name="cap-adv" type="checkbox">
    Morningstar Stewardship <input name="mstar-stewardship" type="checkbox">
    Firm Specific <input name="firm-specific" type="checkbox">
    <br><br> 

    Please select the Funds:<br>
    <input type="radio" name="GE" value="GE"> GE<br>
    <input type="radio" name="CFE" value="CFE"> CFE<br>
    <input type="radio" name="IE" value="IE"> IE<br>
    <input type="radio" name="USE" value="USE" > USE<br>
    <input type="radio" name="CIB" value="CIB"> CIB<br>
    <input type="radio" name="ETOP" value="ETOP"> ETOP<br>
    <input type="radio" name="GBAL" value="GBAL" > GBAL<br>
    <input type="radio" name="CCPFI" value="CCPFI"> CCPFI<br>
    <input type="radio" name="WBF" value="WBF"> WBF<br>
    <input type="radio" name="SMA" value="SMA"> SMA<br><br>

    If other please enter the fund:
    <input type="text" name="other-fund">
    <br><br>
</form>