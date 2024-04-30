package com.example.mangashelfv2

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    Test1_NavigationTest::class,
    Test2_ElementsPositionTest::class,
    Test3_CommonIntentTest::class,
    Test4_RecordEspresso::class
)
class Test0_AllTestsSuite {
}

