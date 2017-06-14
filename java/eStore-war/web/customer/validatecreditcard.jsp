<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>eStore -Credit Card Details and Payment Confirmation</title>
        <SCRIPT LANGUAGE="JavaScript">
        <!-- Original:  Simon Tneoh (tneohcb@pc.jaring.my) -->

        <!-- This script and many more are available free online at -->
        <!-- The JavaScript Source!! http://javascript.internet.com -->

        <!-- Begin
        var Cards = new makeArray(8);
        Cards[0] = new CardType("MasterCard", "51,52,53,54,55", "16");
        var MasterCard = Cards[0];
        Cards[1] = new CardType("VisaCard", "4", "13,16");
        var VisaCard = Cards[1];
        Cards[2] = new CardType("AmExCard", "34,37", "15");
        var AmExCard = Cards[2];
        Cards[3] = new CardType("DinersClubCard", "30,36,38", "14");
        var DinersClubCard = Cards[3];
        Cards[4] = new CardType("DiscoverCard", "6011", "16");
        var DiscoverCard = Cards[4];
        Cards[5] = new CardType("enRouteCard", "2014,2149", "15");
        var enRouteCard = Cards[5];
        Cards[6] = new CardType("JCBCard", "3088,3096,3112,3158,3337,3528", "16");
        var JCBCard = Cards[6];
        var LuhnCheckSum = Cards[7] = new CardType();

        /*************************************************************************\
        CheckCardNumber(form)
        function called when users click the "check" button.
        \*************************************************************************/
        function CheckCardNumber(form) {
        var tmpyear;
        if (form.CardNumber.value.length == 0) {
        alert("Please enter a Card Number.");
        form.CardNumber.focus();
        return;
        }
        if (form.ExpYear.value.length == 0) {
        alert("Please enter the Expiration Year.");
        form.ExpYear.focus();
        return;
        }
        if (form.ExpYear.value > 96)
        tmpyear = "19" + form.ExpYear.value;
        else if (form.ExpYear.value < 21)
        tmpyear = "20" + form.ExpYear.value;
        else {
        alert("The Expiration Year is not valid.");
        return;
        }
        tmpmonth = form.ExpMon.options[form.ExpMon.selectedIndex].value;
        // The following line doesn't work in IE3, you need to change it
        // to something like "(new CardType())...".
        // if (!CardType().isExpiryDate(tmpyear, tmpmonth)) {
        if (!(new CardType()).isExpiryDate(tmpyear, tmpmonth)) {
        alert("This card has already expired.");
        return;
        }
        card = form.CardType.options[form.CardType.selectedIndex].value;
        var retval = eval(card + ".checkCardNumber(\"" + form.CardNumber.value +
        "\", " + tmpyear + ", " + tmpmonth + ");");
        cardname = "";
        if (retval)
        {
        // comment this out if used on an order form
        alert("Thank you for shopping with us");
        window.location="/eStore-Web/ShoppingCart/CheckOutByCreditCard";
        }
        else {
        // The cardnumber has the valid luhn checksum, but we want to know which
        // cardtype it belongs to.
        for (var n = 0; n < Cards.size; n++) {
        if (Cards[n].checkCardNumber(form.CardNumber.value, tmpyear, tmpmonth)) {
        cardname = Cards[n].getCardType();
        break;
           }
        }
        if (cardname.length > 0) {
        alert("This looks like a " + cardname + " number, not a " + card + " number.");
        }
        else {
        alert("This card number is not valid.");
              }
           }
        }
        /*************************************************************************\
        Object CardType([String cardtype, String rules, String len, int year, 
                                                int month])
        cardtype    : type of card, eg: MasterCard, Visa, etc.
        rules       : rules of the cardnumber, eg: "4", "6011", "34,37".
        len         : valid length of cardnumber, eg: "16,19", "13,16".
        year        : year of expiry date.
        month       : month of expiry date.
        eg:
        var VisaCard = new CardType("Visa", "4", "16");
        var AmExCard = new CardType("AmEx", "34,37", "15");
        \*************************************************************************/
        function CardType() {
        var n;
        var argv = CardType.arguments;
        var argc = CardType.arguments.length;

        this.objname = "object CardType";

        var tmpcardtype = (argc > 0) ? argv[0] : "CardObject";
        var tmprules = (argc > 1) ? argv[1] : "0,1,2,3,4,5,6,7,8,9";
        var tmplen = (argc > 2) ? argv[2] : "13,14,15,16,19";

        this.setCardNumber = setCardNumber;  // set CardNumber method.
        this.setCardType = setCardType;  // setCardType method.
        this.setLen = setLen;  // setLen method.
        this.setRules = setRules;  // setRules method.
        this.setExpiryDate = setExpiryDate;  // setExpiryDate method.

        this.setCardType(tmpcardtype);
        this.setLen(tmplen);
        this.setRules(tmprules);
        if (argc > 4)
        this.setExpiryDate(argv[3], argv[4]);

        this.checkCardNumber = checkCardNumber;  // checkCardNumber method.
        this.getExpiryDate = getExpiryDate;  // getExpiryDate method.
        this.getCardType = getCardType;  // getCardType method.
        this.isCardNumber = isCardNumber;  // isCardNumber method.
        this.isExpiryDate = isExpiryDate;  // isExpiryDate method.
        this.luhnCheck = luhnCheck;// luhnCheck method.
        return this;
        }

        /*************************************************************************\
        boolean checkCardNumber([String cardnumber, int year, int month])
        return true if cardnumber pass the luhncheck and the expiry date is
        valid, else return false.
        \*************************************************************************/
        function checkCardNumber() {
        var argv = checkCardNumber.arguments;
        var argc = checkCardNumber.arguments.length;
        var cardnumber = (argc > 0) ? argv[0] : this.cardnumber;
        var year = (argc > 1) ? argv[1] : this.year;
        var month = (argc > 2) ? argv[2] : this.month;

        this.setCardNumber(cardnumber);
        this.setExpiryDate(year, month);

        if (!this.isCardNumber())
        return false;
        if (!this.isExpiryDate())
        return false;

        return true;
        }
        /*************************************************************************\
        String getCardType()
        return the cardtype.
        \*************************************************************************/
        function getCardType() {
        return this.cardtype;
        }
        /*************************************************************************\
        String getExpiryDate()
        return the expiry date.
        \*************************************************************************/
        function getExpiryDate() {
        return this.month + "/" + this.year;
        }
        /*************************************************************************\
        boolean isCardNumber([String cardnumber])
        return true if cardnumber pass the luhncheck and the rules, else return
        false.
        \*************************************************************************/
        function isCardNumber() {
        var argv = isCardNumber.arguments;
        var argc = isCardNumber.arguments.length;
        var cardnumber = (argc > 0) ? argv[0] : this.cardnumber;
        if (!this.luhnCheck())
        return false;

        for (var n = 0; n < this.len.size; n++)
        if (cardnumber.toString().length == this.len[n]) {
        for (var m = 0; m < this.rules.size; m++) {
        var headdigit = cardnumber.substring(0, this.rules[m].toString().length);
        if (headdigit == this.rules[m])
        return true;
        }
        return false;
        }
        return false;
        }

        /*************************************************************************\
        boolean isExpiryDate([int year, int month])
        return true if the date is a valid expiry date,
        else return false.
        \*************************************************************************/
        function isExpiryDate() {
        var argv = isExpiryDate.arguments;
        var argc = isExpiryDate.arguments.length;

        year = argc > 0 ? argv[0] : this.year;
        month = argc > 1 ? argv[1] : this.month;

        if (!isNum(year+""))
        return false;
        if (!isNum(month+""))
        return false;
        today = new Date();
        expiry = new Date(year, month);
        if (today.getTime() > expiry.getTime())
        return false;
        else
        return true;
        }

        /*************************************************************************\
        boolean isNum(String argvalue)
        return true if argvalue contains only numeric characters,
        else return false.
        \*************************************************************************/
        function isNum(argvalue) {
        argvalue = argvalue.toString();

        if (argvalue.length == 0)
        return false;

        for (var n = 0; n < argvalue.length; n++)
        if (argvalue.substring(n, n+1) < "0" || argvalue.substring(n, n+1) > "9")
        return false;

        return true;
        }

        /*************************************************************************\
        boolean luhnCheck([String CardNumber])
        return true if CardNumber pass the luhn check else return false.
        Reference: http://www.ling.nwu.edu/~sburke/pub/luhn_lib.pl
        \*************************************************************************/
        function luhnCheck() {
        var argv = luhnCheck.arguments;
        var argc = luhnCheck.arguments.length;

        var CardNumber = argc > 0 ? argv[0] : this.cardnumber;

        if (! isNum(CardNumber)) {
        return false;
          }

        var no_digit = CardNumber.length;
        var oddoeven = no_digit & 1;
        var sum = 0;

        for (var count = 0; count < no_digit; count++) {
        var digit = parseInt(CardNumber.charAt(count));
        if (!((count & 1) ^ oddoeven)) {
        digit *= 2;
        if (digit > 9)
        digit -= 9;
        }
        sum += digit;
        }
        if (sum % 10 == 0)
        return true;
        else
        return false;
        }

        /*************************************************************************\
        ArrayObject makeArray(int size)
        return the array object in the size specified.
        \*************************************************************************/
        function makeArray(size) {
        this.size = size;
        return this;
        }

        /*************************************************************************\
        CardType setCardNumber(cardnumber)
        return the CardType object.
        \*************************************************************************/
        function setCardNumber(cardnumber) {
        this.cardnumber = cardnumber;
        return this;
        }

        /*************************************************************************\
        CardType setCardType(cardtype)
        return the CardType object.
        \*************************************************************************/
        function setCardType(cardtype) {
        this.cardtype = cardtype;
        return this;
        }

        /*************************************************************************\
        CardType setExpiryDate(year, month)
        return the CardType object.
        \*************************************************************************/
        function setExpiryDate(year, month) {
        this.year = year;
        this.month = month;
        return this;
        }

        /*************************************************************************\
        CardType setLen(len)
        return the CardType object.
        \*************************************************************************/
        function setLen(len) {
        // Create the len array.
        if (len.length == 0 || len == null)
        len = "13,14,15,16,19";

        var tmplen = len;
        n = 1;
        while (tmplen.indexOf(",") != -1) {
        tmplen = tmplen.substring(tmplen.indexOf(",") + 1, tmplen.length);
        n++;
        }
        this.len = new makeArray(n);
        n = 0;
        while (len.indexOf(",") != -1) {
        var tmpstr = len.substring(0, len.indexOf(","));
        this.len[n] = tmpstr;
        len = len.substring(len.indexOf(",") + 1, len.length);
        n++;
        }
        this.len[n] = len;
        return this;
        }

        /*************************************************************************\
        CardType setRules()
        return the CardType object.
        \*************************************************************************/
        function setRules(rules) {
        // Create the rules array.
        if (rules.length == 0 || rules == null)
        rules = "0,1,2,3,4,5,6,7,8,9";

        var tmprules = rules;
        n = 1;
        while (tmprules.indexOf(",") != -1) {
        tmprules = tmprules.substring(tmprules.indexOf(",") + 1, tmprules.length);
        n++;
        }
        this.rules = new makeArray(n);
        n = 0;
        while (rules.indexOf(",") != -1) {
        var tmpstr = rules.substring(0, rules.indexOf(","));
        this.rules[n] = tmpstr;
        rules = rules.substring(rules.indexOf(",") + 1, rules.length);
        n++;
        }
        this.rules[n] = rules;
        return this;
        }
        //  End -->
        </script>		
    </head>

<body bgcolor="#000033" link="#33CCFF" vlink="#33CCFF">
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
  <tr>
    <td><div align="center"><img src="/eStore-Web/customer/images/header.jpg" width="935" height="98"></div></td>
  </tr>
</table>
<br>
<br>
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="23%" height="472" valign="top" bgcolor="#003366"><br>
      <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#000033">
      <tr>
        <td><div align="center"><font color="#FFFFFF" size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Navigation</strong></font></div></td>
      </tr>
    </table>
    <p><font size="2"><a href="/eStore-Web/ViewProduct"><font face="Verdana, Arial, Helvetica, sans-serif"> 
      </font></a></font><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"><a href="/eStore-Web/customer/main.jsp">Home</a></font></font></p>
    <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"><a href="/eStore-Web/ViewProduct">Browse Product</a></font></font></p>
    <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewCategory/Customer">Browse Product By Category</a></font></p>
    <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ShoppingCart/View">View Your Shopping Cart</a></font></p>
    <p> <font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ShoppingCart/CustomerViewOrder">View Your Order Status</a></font></p>
    <p> <font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/UpdateCustomer/EditForm">Edit Your Personal Details</a></font></p>
    <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewCustomer/Customer">View Your Personal Details</a></font></p>
    <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/ViewPostage/CustomerAll">View Postage Rate</a></font></p>
    <p><font size="2"><font face="Verdana, Arial, Helvetica, sans-serif"><img src="/eStore-Web/customer/images/button.gif" width="13" height="10"></font></font><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><a href="/eStore-Web/LogOut/Customer">Log-Out</a></font></p></td>
    <td width="77%" valign="baseline" bgcolor="#FFFFFF"><br>      
      &nbsp;<font size="4" face="Verdana, Arial, Helvetica, sans-serif"><strong>&nbsp;Credit Card Details and Payment Confirmation </strong></font> <br>
      <br>      <form name="ThisForm">
        <table width="100%"  border="0" cellspacing="0" cellpadding="10">
          <tr>
            <td width="25%"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Name On Card: </font></strong></td>
            <td width="75%"><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input type="text" name="textfield">
            </font></strong></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Card Number:</font></strong></td>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <input name="CardNumber" size="16" maxlength="19">
            </font></strong></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Card Type:</font></strong></td>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
              <select name="CardType">
                <option value="MasterCard">MasterCard
                <option value="VisaCard">Visa
                <option value="AmExCard">American Express
                <option value="DinersClubCard">Diners Club
                <option value="DiscoverCard">Discover
                <option value="enRouteCard">enRoute
                <option value="JCBCard">JCB
              </select>
            </font></strong></td>
          </tr>
          <tr>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Expiration Date:</font></strong></td>
            <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Month
                  <select name="ExpMon">
                    <option value="1" selected>1
                    <option value="2">2
                    <option value="3">3
                    <option value="4">4
                    <option value="5">5
                    <option value="6">6
                    <option value="7">7
                    <option value="8">8
                    <option value="9">9
                    <option value="10">10
                    <option value="11">11
                    <option value="12">12
              </select>
Year
<input name="ExpYear" size="2" maxlength="2">
            </font></strong></td>
          </tr>
          <tr>
            <td><input name="button" type="button" onClick="CheckCardNumber(this.form)" value="Confirm Payment"></td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <p>&nbsp;</p>
      </form>
    </td>
  </tr>
</table>
</body>
</html>
