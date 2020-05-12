<?php

include("config.php");

	$nama_penduduk=$_POST['nama_penduduk'];
	$ttl_penduduk=$_POST['ttl_penduduk'];
	$alamat_penduduk=$_POST['alamat_penduduk'];
	$hp_penduduk=$_POST['hp_penduduk'];

	$sql = "INSERT INTO penduduk(nama_penduduk, ttl_penduduk, alamat_penduduk, hp_penduduk) values('$nama_penduduk','$ttl_penduduk', '$alamat_penduduk', '$hp_penduduk')";
	$query = mysqli_query($db, $sql);

	//apakah data berhasil di update
	if($query ) {

	}else{
		//kalau gagal tampilkan pesan 
		die("Gagal menyimpan perubahan...");
	}