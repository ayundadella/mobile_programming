<?php

include("config.php");

	$isi_tagline=$_POST['isi_tagline'];

	$sql = "UPDATE tagline SET isi_tagline='$isi_tagline' WHERE id_tagline=3";
	$query = mysqli_query($db, $sql);

	//apakah data berhasil di update
	if(query ) {

	}else{
		//kalau gagal tampilkan pesan 
		die("Gagal menyimpan perubahan...");
	}