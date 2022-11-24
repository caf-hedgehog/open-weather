"use strict";
// 都道府県フォーム生成
$(function () {
  $.getJSON("pref_city.json", function (data) {
    for (let pref of data) {
      let key = Object.keys(pref);
      let op = document.createElement("option");
      op.value = key;
      op.text = pref[key].pref;
      document.getElementById("select-pref").append(op);
    }
  });
});

// 都道府県メニューに連動した市区町村フォーム生成
$("#select-pref").on("change", function () {
  $("#select-city option:nth-child(n+2)").remove(); // ※1 市区町村フォームクリ
  $.getJSON("pref_city.json", function (data) {
    for (let prefs of data) {
      if ($("#select-pref").val() === Object.keys(prefs).toString()) {
        let key = Object.keys(prefs);
        for (let i = 0; i < prefs[key].city.length; i++) {
          let op = document.createElement("option");
          op.value = prefs[key].city[i].name;
          op.text = prefs[key].city[i].name;
          document.getElementById("select-city").append(op);
        }
      }
    }
  });
});
