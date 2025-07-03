package com.example.xr.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.xr.compose.platform.LocalSpatialCapabilities
import androidx.xr.compose.spatial.Orbiter
import androidx.xr.compose.spatial.OrbiterEdge
import androidx.xr.compose.spatial.Subspace
import androidx.xr.compose.subspace.SpatialPanel
import androidx.xr.compose.subspace.layout.SubspaceModifier
import androidx.xr.compose.subspace.layout.fillMaxSize
import androidx.xr.compose.subspace.layout.movable
import androidx.xr.compose.subspace.layout.padding
import androidx.xr.compose.subspace.layout.resizable
import com.example.xr.R
import com.example.xr.ui.components.EnvironmentControls
import com.example.xr.ui.components.SearchBar


@Composable
fun AndroidXRApp() {
    if (LocalSpatialCapabilities.current.isSpatialUiEnabled) {
        SpatialLayout(
            primaryContent = { PrimaryContent() }
        )
    } else {
        NonSpatialLayout(
            primaryPane = { PrimaryContent() }
        )
    }
}

/**
 * Layout that displays content in [SpatialPanel]s, should be used when spatial UI is enabled.
 */
@Composable
private fun SpatialLayout(
    primaryContent: @Composable () -> Unit
) {
    Subspace {
        SpatialPanel(
            modifier = SubspaceModifier
                .fillMaxSize()
                .padding(left = 16.dp)
                .movable()
                .resizable()
        ) {
            Column {
                TopAppBar()
                primaryContent()
            }
        }
    }
}

/**
 * Layout that displays content in a 2-pane layout, should be used when spatial UI is not enabled.
 */
@Composable
private fun NonSpatialLayout(
    primaryPane: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .padding(16.dp)
            .systemBarsPadding()
    ) {
        TopAppBar()
        Spacer(Modifier.height(16.dp))
        primaryPane()
    }
}

/**
 * Contains controls that decompose into Orbiters when spatial UI is enabled
 */
@Composable
private fun TopAppBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
    ) {
        Spacer(Modifier.weight(1f))
        Orbiter(
            position = OrbiterEdge.Top,
            offset = dimensionResource(R.dimen.top_ornament_padding),
            alignment = Alignment.Start
        ) {
            SearchBar()
        }
        Spacer(Modifier.weight(1f))
        Orbiter(
            position = OrbiterEdge.Top,
            offset = dimensionResource(R.dimen.top_ornament_padding),
            alignment = Alignment.End
        ) {
            EnvironmentControls()
        }
    }
}

@Composable
private fun PrimaryContent(modifier: Modifier = Modifier) {
    spatialPopup_HSM_dismissOnBackPressTrue_invokesDismissRequest(modifier)
}