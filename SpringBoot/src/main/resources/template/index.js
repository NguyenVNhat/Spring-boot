function fetchDataAndFillTable() {
  fetch('http://localhost:8080/api/account/getAll')
    .then(response => response.json())
    .then(data => {
      console.log(data); // Log dữ liệu ra console để xem cấu trúc của nó

      // Kiểm tra xem dữ liệu có trạng thái "OK" không và có tồn tại mảng dữ liệu không
      if (data.status === "OK" && data.data && Array.isArray(data.data)) {
        // Gọi hàm fillTable để điền dữ liệu vào bảng
        fillTable(data.data);
      } else {
        console.error('No account data found');
      }
    })
    .catch(error => console.error('Error fetching data:', error));
}

function fillTable(data) {
  var tableBody = document.querySelector('tbody');
  tableBody.innerHTML = ''; // Xóa bất kỳ hàng nào đã được điền trước đó

  data.forEach(account => {
    var row = document.createElement('tr');
    row.innerHTML = `
      <td>${account.id}</td>
      <td>${account.username}</td>
      <td>${account.password}</td>
      <td>${account.active}</td>
      <td>${account.role}</td>
    `;
    tableBody.appendChild(row);
  });
}

// Gọi hàm fetchDataAndFillTable() khi trang được tải
fetchDataAndFillTable();
