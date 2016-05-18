<?php
$sp = "<br/>\n";
//类型强转和java类似（强转的类型）
foreach ((array) $_GET as $k => $v) {
	echo "GET $k : $v".$sp;
}
?>