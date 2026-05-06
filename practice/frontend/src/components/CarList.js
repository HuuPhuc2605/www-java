import React, { useEffect, useState } from "react";
import "./CarList.css";

function CarList() {
  const [cars, setCars] = useState([]);
  const [formData, setFormData] = useState({
    maxe: "",
    tenxe: "",
    giaban: "",
    dungtich: "",
    hinhanh: "",
    mahang: "",
  });
  const [editing, setEditing] = useState(null);

  // Lấy dữ liệu từ API
  useEffect(() => {
    fetch("http://localhost:8080/api/xeoto")
      .then((res) => res.json())
      .then((data) => setCars(data))
      .catch((err) => console.error("Lỗi khi gọi API:", err));
  }, []);

  // Xử lý thay đổi input
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // Thêm hoặc cập nhật xe
  const handleSubmit = (e) => {
    e.preventDefault();
    const method = editing ? "PUT" : "POST";
    const url = editing
      ? `http://localhost:8080/api/xeoto/${editing}`
      : "http://localhost:8080/api/xeoto";

    fetch(url, {
      method: method,
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(formData),
    })
      .then((res) => res.json())
      .then(() => {
        setFormData({
          maxe: "",
          tenxe: "",
          giaban: "",
          dungtich: "",
          hinhanh: "",
          mahang: "",
        });
        setEditing(null);
        return fetch("http://localhost:8080/api/xeoto")
          .then((res) => res.json())
          .then((data) => setCars(data));
      });
  };

  // Xóa xe với xác nhận
  const handleDelete = (id) => {
    if (window.confirm("Bạn có chắc chắn muốn xóa xe này không?")) {
      fetch(`http://localhost:8080/api/xeoto/${id}`, { method: "DELETE" }).then(
        () => setCars((prev) => prev.filter((car) => car.maxe !== id)),
      );
    }
  };

  // Chỉnh sửa xe
  const handleEdit = (car) => {
    setFormData({
      maxe: car.maxe,
      tenxe: car.tenxe,
      giaban: car.giaban,
      dungtich: car.dungtich,
      hinhanh: car.hinhanh,
      mahang: car.hangXe ? car.hangXe.mahang : "",
    });
    setEditing(car.maxe);
  };

  return (
    <div className="car-container">
      <h2>Quản lý xe ô tô</h2>

      {/* Form thêm/sửa */}
      <form className="car-form" onSubmit={handleSubmit}>
        <input
          name="maxe"
          value={formData.maxe}
          onChange={handleChange}
          placeholder="Mã xe"
          required
        />
        <input
          name="tenxe"
          value={formData.tenxe}
          onChange={handleChange}
          placeholder="Tên xe"
          required
        />
        <input
          name="giaban"
          value={formData.giaban}
          onChange={handleChange}
          placeholder="Giá bán"
          required
        />
        <input
          name="dungtich"
          value={formData.dungtich}
          onChange={handleChange}
          placeholder="Dung tích"
          required
        />
        <input
          name="hinhanh"
          value={formData.hinhanh}
          onChange={handleChange}
          placeholder="Tên file ảnh"
        />
        <input
          name="mahang"
          value={formData.mahang}
          onChange={handleChange}
          placeholder="Mã hãng"
          required
        />
        <button type="submit">{editing ? "Cập nhật" : "Thêm xe"}</button>
      </form>

      {/* Hiển thị card */}
      <div className="car-grid">
        {cars.map((c) => (
          <div className="car-card" key={c.maxe}>
            <img
              src={
                c.hinhanh
                  ? `/images/${c.hinhanh}`
                  : "https://via.placeholder.com/200"
              }
              alt={c.tenxe}
              className="car-image"
            />
            <div className="car-info">
              <h3>{c.tenxe}</h3>
              <p>
                <strong>Giá bán:</strong> {Number(c.giaban).toLocaleString()}{" "}
                VND
              </p>
              <p>
                <strong>Dung tích:</strong> {c.dungtich} L
              </p>
              <p>
                <strong>Hãng xe:</strong>{" "}
                {c.hangXe ? c.hangXe.tenhang : "Không rõ"}
              </p>
            </div>
            <div className="car-actions">
              <button onClick={() => handleDelete(c.maxe)}>Xóa</button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default CarList;
