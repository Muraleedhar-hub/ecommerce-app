<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Kissan-Maal</title>
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center" valign="top" bgcolor="#838383"
				style="background-color: darkgreen;"><br> <br>
				<table width="600" border="0" cellspacing="0" cellpadding="0">


					<tr>
						<td style="
									height: 50px;
									background-color: darkgrey;
									padding-left: 1px;
									padding-right: 1px;
									font-size: larger;
									font-family: ui-monospace;
									padding-bottom: 1px;
									padding-top: 1px;border: 1px solid darkgreen;text-align:center;">
							Item No
						</td>
						<td style="
									height: 50px;
									background-color: darkgrey;
									padding-left: 1px;
									padding-right: 1px;
									font-size: larger;
									font-family: ui-monospace;
									padding-bottom: 1px;
									padding-top: 1px;border: 1px solid darkgreen;text-align:center;">
							Item Name
						</td>
						<td style="
									height: 50px;
									background-color: darkgrey;
									padding-left: 1px;
									padding-right: 1px;
									font-size: larger;
									font-family: ui-monospace;
									padding-bottom: 1px;
									padding-top: 1px;border: 1px solid darkgreen;text-align:center;">
							Quantity
						</td>
						<td style="
									height: 50px;
									background-color: darkgrey;
									padding-left: 1px;
									padding-right: 1px;
									font-size: larger;
									font-family: ui-monospace;
									padding-bottom: 1px;
									padding-top: 1px;border: 1px solid darkgreen;text-align:center;">
							Amount
						</td>
					</tr>

					  <#list items as item>


					<tr>
						<td style="
									height: 50px;
									background-color: lightgray;
									padding-left: 1px;
									padding-right: 1px;
									font-size: larger;
									font-family: ui-monospace;
									padding-bottom: 1px;
									padding-top: 1px;border: 1px solid darkgreen;text-align:center;">
							${item.itemNo}
						</td>
						<td style="
									height: 50px;
									background-color: lightgray;
									padding-left: 1px;
									padding-right: 1px;
									font-size: larger;
									font-family: ui-monospace;
									padding-bottom: 1px;
									padding-top: 1px;border: 1px solid darkgreen;text-align:center;">
							${item.itemName}
						</td>
						<td style="
									height: 50px;
									background-color: lightgray;
									padding-left: 1px;
									padding-right: 1px;
									font-size: larger;
									font-family: ui-monospace;
									padding-bottom: 1px;
									padding-top: 1px;border: 1px solid darkgreen;text-align:center;">
							${item.quantity}
						</td>
						<td style="
									height: 50px;
									background-color: lightgray;
									padding-left: 1px;
									padding-right: 1px;
									font-size: larger;
									font-family: ui-monospace;
									padding-bottom: 1px;
									padding-top: 1px;border: 1px solid darkgreen;text-align:center;">
							${item.price}
						</td>
					</tr>

					</#list>
					<tr>
						<td style="
									height: 50px;
									background-color: lightgray;
									padding-left: 1px;
									padding-right: 1px;
									font-size: larger;
									font-family: ui-monospace;
									padding-bottom: 1px;
									padding-top: 1px;border-top: 1px solid darkgreen;text-align:center;">
							Total Amount
						</td>
												<td style="
									height: 50px;
									background-color: lightgray;
									padding-left: 1px;
									padding-right: 1px;
									font-size: larger;
									font-family: ui-monospace;
									padding-bottom: 1px;
									padding-top: 1px;text-align:center;border-top: 1px solid darkgreen;">

						</td>
												<td style="
									height: 50px;
									background-color: lightgray;
									padding-left: 1px;
									padding-right: 1px;
									font-size: larger;
									font-family: ui-monospace;
									padding-bottom: 1px;
									padding-top: 1px;text-align:center;border-top: 1px solid darkgreen;border-right: 1px solid darkgreen;">

						</td>
						<td style="
									height: 50px;
									background-color: lightgray;
									padding-left: 1px;
									padding-right: 1px;
									font-size: larger;
									font-family: ui-monospace;
									padding-bottom: 1px;
									padding-top: 1px;border: 1px solid darkgreen;text-align:center;">
							${totalAmount}
						</td>
					</tr>
				</table> <br> <br>
		</tr>
	</table>
</body>
</html>
