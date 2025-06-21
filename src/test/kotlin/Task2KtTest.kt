package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Test

class Task2KtTest {

 @Test
 fun testMasterCard_NoCommissionUnderMax() {
  val result = calculateCommission(500_000.0, 750_000.0, "MasterCard")
  assertEquals(0.0, result, 0.00001)
 }

 @Test
 fun testMaestro_NoCommissionUnderMax() {
  val result = calculateCommission(500_000.0, 750_000.0, "Maestro")
  assertEquals(0.0, result, 0.00001)
 }

 @Test
 fun testVKPay_NoCommissionUnderMax() {
  val result = calculateCommission(500_000.0, 750_000.0, "VK Pay")
  assertEquals(0.0, result, 0.00001)
 }

 @Test
 fun testVisa_NoCommissionUnderMax() {
  val result = calculateCommission(500_000.0, 750_000.0, "Visa")
  assertEquals(0.0075, result, 0.00001)
 }

 @Test
 fun testMIR_NoCommissionUnderMax() {
  val result = calculateCommission(500_000.0, 750_000.0, "MIR")
  assertEquals(0.0075, result, 0.00001)
 }

 @Test
 fun testVisa_CommissionOverMax() {
  val result = calculateCommission(800_000.0, 750_000.0, "Visa")
  assertEquals(0.0075, result, 0.00001)
 }

 @Test
 fun testMIR_CommissionOverMax() {
  val result = calculateCommission(800_000.0, 750_000.0, "MIR")
  assertEquals(0.0075, result, 0.00001)
 }

 @Test
 fun testMasterCard_CommissionOverMax() {
  val result = calculateCommission(800_000.0, 750_000.0, "MasterCard")
  assertEquals(0.006, result, 0.00001)
 }

 @Test
 fun testMaestro_CommissionOverMax() {
  val result = calculateCommission(800_000.0, 750_000.0, "Maestro")
  assertEquals(0.006, result, 0.00001)
 }

 @Test
 fun testVKPay_CommissionAlwaysZero() {
  val result = calculateCommission(1_000_000.0, 750_000.0, "VK Pay")
  assertEquals(0.0, result, 0.00001)
 }

 @Test
 fun testFormatToRubles_TypicalValue() {
  val result = formatToRubles(123456.0)
  assertEquals("1234 руб. 56 коп.", result)
 }

 @Test
 fun testFormatToRubles_ZeroValue() {
  val result = formatToRubles(0.0)
  assertEquals("0 руб. 0 коп.", result)
 }

 @Test
 fun testFormatToRubles_ZeroRubles() {
  val result = formatToRubles(56.0)
  assertEquals("0 руб. 56 коп.", result)
 }

 @Test
 fun testFormatToRubles_ZeroKopecks() {
  val result = formatToRubles(5600.0)
  assertEquals("56 руб. 20 коп.", result)
 }


}