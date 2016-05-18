 <?php
 //散列数组列表
 $arr = array(
            array(
		        "name" => "James",
				"sex" => "M",
				"age" => "28"
				),
			array(
			    "name" => "Iris",
				"sex" => "F",
				"age" => "27"
				)
		);
 ?>
 <table border=1 cellspacing=1 cellpadding=5>
    <tr>
      <td>Name</td>
	  <td>Sex</td>
	  <td>Age</td>
    </tr>
<?php
   foreach ($arr as $row) {
	    echo "<tr>";
	    echo  "<td>".$row["name"]."</td>";
		echo  "<td>".$row["sex"]."</td>";
		echo  "<td>".$row["age"]."</td>";
		echo "</tr>";
   }
?>
</table>