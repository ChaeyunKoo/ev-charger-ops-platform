"use client";

import { useMemo, useState } from "react";
import { useRouter } from "next/navigation";

import Header from "@/app/components/Header";
import ChatWidget from "@/app/components/ChatWidget";
import styles from "./page.module.css";

import UnconfirmStatusChart from "@/app/components/chart/UnconfirmStatusChart";
import UnconfirmRegionChart from "@/app/components/chart/UnconfirmRegionChart";
import SummaryChart from "@/app/components/chart/SummaryChart";

import Search from "@/app/components/search";
import PagedList from "@/app/components/list/PagedList";

export default function MonitoringPage() {
    const router = useRouter();

    const LEFT_LIST_VISIBLE_COUNT = 7;
    const LEFT_ROW_HEIGHT = 36;
    const LEFT_ROW_GAP = 8;
    const leftListMaxHeightPx =
        LEFT_LIST_VISIBLE_COUNT * LEFT_ROW_HEIGHT + (LEFT_LIST_VISIBLE_COUNT - 1) * LEFT_ROW_GAP;

    const [region, setRegion] = useState("");
    const [city, setCity] = useState("");
    const [stationType, setStationType] = useState("");
    const [chargeType, setChargeType] = useState("");
    const [stationName, setStationName] = useState("");

    const [chatOpen, setChatOpen] = useState(false);

    // 🎨 편집 모드 및 레이아웃 state
    const [isEditMode, setIsEditMode] = useState(false);
    const [draggedItem, setDraggedItem] = useState(null);

    // 📊 기본 레이아웃 설정 (그리드 위치: row/col로 관리)
    const defaultLayout = [
        { id: "chart1", component: "UnconfirmStatusChart", title: "상태미확인 충전기 현황", gridArea: "2 / 2 / 3 / 3" },
        { id: "chart2", component: "UnconfirmRegionChart", title: "지역별 상태 미확인 비율", gridArea: "2 / 3 / 3 / 4" },
        { id: "chart3", component: "SummaryChart", title: "충전기 상태 현황", gridArea: "2 / 4 / 3 / 5" },
        { id: "list1", component: "PagedList", title: "이상탐지 위험 충전소 리스트", dataKey: "risk", gridArea: "3 / 2 / 4 / 4" },
        { id: "list2", component: "PagedList", title: "상태 미확인 충전소 리스트", dataKey: "unconfirmed", gridArea: "3 / 4 / 4 / 5" },
    ];

    const [layout, setLayout] = useState(defaultLayout);

    // 더미
    const stationList = useMemo(
        () => [
            { id: 1, name: "충전소명 1", status: "사용가능", type: "완속" },
            { id: 2, name: "충전소명 2", status: "사용가능", type: "완속" },
            { id: 3, name: "충전소명 3", status: "사용중", type: "급속" },
            { id: 4, name: "충전소명 4", status: "사용가능", type: "완속" },
            { id: 5, name: "충전소명 5", status: "상태미확인", type: "완속" },
            { id: 6, name: "충전소명 6", status: "사용가능", type: "급속" },
            { id: 7, name: "충전소명 7", status: "사용가능", type: "완속" },
            { id: 8, name: "충전소명 8", status: "사용가능", type: "완속" },
            { id: 9, name: "충전소명 9", status: "사용가능", type: "완속" },
            { id: 10, name: "충전소명 10", status: "사용가능", type: "완속" },
            { id: 11, name: "충전소명 11", status: "사용가능", type: "급속" },
            { id: 12, name: "충전소명 12", status: "사용가능", type: "완속" },
        ],
        []
    );

    const riskStations = useMemo(
        () => Array.from({ length: 12 }, (_, i) => ({ id: i + 1, name: `충전소명 ${i + 1}` })),
        []
    );

    const unconfirmedStations = useMemo(
        () => Array.from({ length: 12 }, (_, i) => ({ id: i + 1, name: `충전소명 ${i + 1}` })),
        []
    );

    const goDetail = (id) => router.push(`/pages/monitoringDetail/${id}`);

    const handleSearch = () => {
        console.log("검색:", { region, city, stationType, chargeType, stationName });
    };

    const handleReset = () => {
        setRegion("");
        setCity("");
        setStationType("");
        setChargeType("");
        setStationName("");
    };

    const handleAlarmSend = () => {
        alert("알림 전송(임시) - API 연결 시 실제 전송 로직으로 교체");
    };

    // 🎨 드래그 앤 드롭 핸들러
    const handleDragStart = (e, item) => {
        if (!isEditMode) return;
        setDraggedItem(item);
        e.dataTransfer.effectAllowed = "move";
    };

    const handleDragOver = (e) => {
        if (!isEditMode) return;
        e.preventDefault();
        e.dataTransfer.dropEffect = "move";
    };

    const handleDrop = (e, targetItem) => {
        if (!isEditMode || !draggedItem || draggedItem.id === targetItem.id) {
            setDraggedItem(null);
            return;
        }
        e.preventDefault();

        // 위치 교환
        const newLayout = layout.map(item => {
            if (item.id === draggedItem.id) {
                return { ...item, gridArea: targetItem.gridArea };
            }
            if (item.id === targetItem.id) {
                return { ...item, gridArea: draggedItem.gridArea };
            }
            return item;
        });

        setLayout(newLayout);
        setDraggedItem(null);
    };

    const handleResetLayout = () => {
        if (window.confirm("레이아웃을 초기화하시겠습니까?")) {
            setLayout(defaultLayout);
        }
    };

    // 📦 컴포넌트 렌더링
    const renderComponent = (item) => {
        const cardClass = isEditMode ? `${styles.card} ${styles.draggableCard}` : styles.card;
        const cardStyle = { gridArea: item.gridArea };

        if (item.component === "UnconfirmStatusChart") {
            return (
                <section
                    key={item.id}
                    className={cardClass}
                    style={cardStyle}
                    draggable={isEditMode}
                    onDragStart={(e) => handleDragStart(e, item)}
                    onDragOver={handleDragOver}
                    onDrop={(e) => handleDrop(e, item)}
                >
                    {isEditMode && <div className={styles.dragHint}>드래그하여 이동</div>}
                    <h3 className={styles.cardTitle}>{item.title}</h3>
                    <UnconfirmStatusChart />
                </section>
            );
        }

        if (item.component === "UnconfirmRegionChart") {
            return (
                <section
                    key={item.id}
                    className={cardClass}
                    style={cardStyle}
                    draggable={isEditMode}
                    onDragStart={(e) => handleDragStart(e, item)}
                    onDragOver={handleDragOver}
                    onDrop={(e) => handleDrop(e, item)}
                >
                    {isEditMode && <div className={styles.dragHint}>드래그하여 이동</div>}
                    <h3 className={styles.cardTitle}>{item.title}</h3>
                    <UnconfirmRegionChart />
                </section>
            );
        }

        if (item.component === "SummaryChart") {
            return (
                <section
                    key={item.id}
                    className={cardClass}
                    style={cardStyle}
                    draggable={isEditMode}
                    onDragStart={(e) => handleDragStart(e, item)}
                    onDragOver={handleDragOver}
                    onDrop={(e) => handleDrop(e, item)}
                >
                    {isEditMode && <div className={styles.dragHint}>드래그하여 이동</div>}
                    <h3 className={styles.cardTitle}>{item.title}</h3>
                    <SummaryChart total={152} />
                </section>
            );
        }

        if (item.component === "PagedList") {
            const isRisk = item.dataKey === "risk";
            const items = isRisk ? riskStations : unconfirmedStations;

            return (
                <div
                    key={item.id}
                    className={cardClass}
                    style={cardStyle}
                    draggable={isEditMode}
                    onDragStart={(e) => handleDragStart(e, item)}
                    onDragOver={handleDragOver}
                    onDrop={(e) => handleDrop(e, item)}
                >
                    {isEditMode && <div className={styles.dragHint}>드래그하여 이동</div>}
                    <PagedList
                        styles={styles}
                        title={item.title}
                        items={items}
                        pageSize={5}
                        onView={goDetail}
                    />
                </div>
            );
        }
    };

    return (
        <div className={styles.page}>
            <Header />

            <main className={styles.main}>
                <div className={styles.inner}>
                    <div className={styles.dashboardGrid}>
                        {/* 왼쪽 검색 패널 (고정) */}
                        <div className={styles.leftPanel}>
                            <Search
                                styles={styles}
                                region={region}
                                setRegion={setRegion}
                                city={city}
                                setCity={setCity}
                                stationType={stationType}
                                setStationType={setStationType}
                                chargeType={chargeType}
                                setChargeType={setChargeType}
                                stationName={stationName}
                                setStationName={setStationName}
                                onSearch={handleSearch}
                                onReset={handleReset}
                                stations={stationList}
                                maxHeightPx={leftListMaxHeightPx}
                                onSelect={goDetail}
                            />
                        </div>

                        {/* 🎨 편집 컨트롤 버튼들 */}
                        <div className={styles.editControls}>
                            {isEditMode && (
                                <button
                                    className={styles.resetBtn}
                                    onClick={handleResetLayout}
                                >
                                    초기화
                                </button>
                            )}
                            <button
                                className={`${styles.editBtn} ${isEditMode ? styles.active : ''}`}
                                onClick={() => setIsEditMode(!isEditMode)}
                            >
                                {isEditMode ? "완료" : "편집"}
                            </button>
                        </div>

                        {/* 📊 동적 레이아웃 렌더링 */}
                        {layout.map(item => renderComponent(item))}

                        <div className={styles.gridEmpty} />
                    </div>
                </div>

                <ChatWidget open={chatOpen} onClose={() => setChatOpen(false)} />
            </main>

            <div className={styles.fixedButtons}>
                <button className={styles.chatBtn} onClick={() => setChatOpen((p) => !p)}>
                    챗봇
                </button>
                <button className={styles.alarmBtn} onClick={handleAlarmSend}>
                    알림 전송
                </button>
            </div>
        </div>
    );
}
